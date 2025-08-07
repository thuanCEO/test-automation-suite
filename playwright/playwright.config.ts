import { defineConfig } from '@playwright/test';
import { TimeOut } from '../playwright/src/constants/TimeOut';
import { Reporter } from '../playwright/src/constants/Reporter';
import { DriverConfig } from '../playwright/src/config/DriverConfig';

export default defineConfig({
  timeout: TimeOut.XLONG,
  retries: DriverConfig.retries,
  workers: DriverConfig.workers,
  expect: {
    timeout: TimeOut.DEFAULT,
  },
  reporter: Reporter.reporter,
  name: DriverConfig.name,
  projects: [
    {
      name: 'test-ui',
      testDir: './src/test-ui/tests',
      use: {
        browserName: DriverConfig.browserName,
        channel: DriverConfig.channel,
        headless: DriverConfig.headless,
        ignoreHTTPSErrors: DriverConfig.ignoreHTTPSErrors,
        screenshot: DriverConfig.screenshot,
        video: DriverConfig.video,
        trace: DriverConfig.trace,
      },
    },
    {
      name: 'test-api',
      testDir: './src/test-api/tests',
      use: {},
    }
  ],
});
