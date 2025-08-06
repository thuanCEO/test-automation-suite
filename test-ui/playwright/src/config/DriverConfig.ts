import { BrowserEnum, BrowserChannelEnum, BrowserNameEnum } from '@enums/BrowserEnum.js';

export const DriverConfig = {
    testDir: '@src/tests',
    ignoreHTTPSErrors: true,
    headless: true,
    retries: 1,
    workers: 1,
    name: BrowserNameEnum.CHROMIUM,
    browserName: BrowserEnum.CHROMIUM as const,
    channel: BrowserChannelEnum.CHROME as const,
    screenshot: 'only-on-failure' as const,
    video: 'retain-on-failure' as const,
    trace: 'on-first-retry' as const,
};