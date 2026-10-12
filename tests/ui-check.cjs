const { chromium } = require(
  process.env.PLAYWRIGHT_MODULE || "playwright-core",
);
const { pathToFileURL } = require("node:url");
const path = require("node:path");
const assert = require("node:assert/strict");
(async () => {
  const browser = await chromium.launch({
    executablePath: process.env.CHROME_PATH || "/usr/bin/google-chrome-stable",
    headless: true,
    args: ["--no-sandbox"],
  });
  const context = await browser.newContext({ offline: true });
  const page = await context.newPage();
  const errors = [],
    requests = [];
  page.on("pageerror", (error) => errors.push(error.message));
  page.on("request", (request) => {
    if (/^https?:/.test(request.url())) requests.push(request.url());
  });
  await page.goto(pathToFileURL(path.resolve(__dirname, "../index.html")).href);
  await page.evaluate(() => document.fonts.ready);
  assert.equal(await page.locator(".item").count(), 17);
  assert.equal(await page.locator("#program-nav a").count(), 17);
  await page.locator("#q").fill("17");
  assert.equal(await page.locator(".item:visible").count(), 1);
  assert.equal(await page.locator("#program-nav a:visible").count(), 1);
  await page.locator("#q").fill("");
  await page.locator("#p8 .h").click();
  await page.waitForTimeout(400);
  await page.locator("#p8 .tab").last().click();
  assert.equal(
    await page.locator("#p8 .tab").last().getAttribute("aria-selected"),
    "true",
  );
  await page.locator("#p8 .cp").click();
  await page.waitForTimeout(100);
  assert.match(await page.locator("#p8 .cp").innerText(), /Copied/);
  await page.locator("#ex").click();
  assert.equal(await page.locator(".item.open").count(), 17);
  await page.locator("#co").click();
  assert.equal(await page.locator(".item.open").count(), 0);
  await page.locator("#theme-toggle").click();
  assert.equal(await page.locator("html").getAttribute("data-theme"), "light");
  await page.locator("#theme-toggle").click();
  for (const width of [390, 768, 1440]) {
    await page.setViewportSize({ width, height: 900 });
    assert.equal(
      await page.evaluate(
        () => document.documentElement.scrollWidth > innerWidth,
      ),
      false,
      "overflow at " + width,
    );
  }
  await page.locator("#program-nav a").first().click();
  await page.waitForTimeout(400);
  await page.screenshot({ path: "/tmp/ajfp-desktop.png" });
  await page.setViewportSize({ width: 390, height: 844 });
  await page.locator("#menu").click();
  assert.equal(await page.locator("#rail").isVisible(), true);
  await page.keyboard.press("Escape");
  assert.equal(await page.locator("#rail").isVisible(), false);
  await page.screenshot({ path: "/tmp/ajfp-mobile.png" });
  await page.emulateMedia({ reducedMotion: "reduce" });
  await page.evaluate(() =>
    scrollTo({
      top: document.documentElement.scrollHeight,
      behavior: "instant",
    }),
  );
  await page.waitForTimeout(100);
  assert.match(
    await page
      .locator(".progress")
      .evaluate((el) => getComputedStyle(el).transform),
    /^matrix\(1,/,
  );
  assert.deepEqual(errors, []);
  assert.deepEqual(requests, []);
  await browser.close();
  console.log(
    "17 programs: offline fonts, search, tabs, copying, accordions, theme, mobile menu, progress and responsive widths passed.",
  );
})().catch((error) => {
  console.error(error);
  process.exit(1);
});
