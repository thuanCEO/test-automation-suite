import { defineConfig } from '@playwright/test';
import { TimeOut } from '../playwright/src/constants/TimeOut';
import { Reporter } from '../playwright/src/constants/Reporter';
import { DriverConfig } from '../playwright/src/config/DriverConfig';

export default defineConfig({
  testDir: DriverConfig.testDir,
  timeout: TimeOut.XLONG,
  retries: DriverConfig.retries,
  workers: DriverConfig.workers,
  expect: {
    timeout: TimeOut.DEFAULT,
  },
  reporter: Reporter.reporter,
  name: DriverConfig.name,
  use: {
    browserName: DriverConfig.browserName,
    channel: DriverConfig.channel,
    headless: DriverConfig.headless,
    ignoreHTTPSErrors: DriverConfig.ignoreHTTPSErrors,
    screenshot: DriverConfig.screenshot,
    video: DriverConfig.video,
    trace: DriverConfig.trace,
  }
});
