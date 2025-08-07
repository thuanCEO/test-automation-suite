import { test, expect } from '@playwright/test';
import { TestArchitectPage } from '../../pages/TestArchitect/ArchitectPages';
import { LoginPage } from '../../pages/TestArchitect/LoginPage';
import { SaveScreenshot } from '../../utils/SaveScreenshot';

test.describe('@Smoke @LoginTA', () => {
  test('Login - Register with email to login', async ({ page }) => {
    const testArchitectPage = new TestArchitectPage(page);
    const loginPage = new LoginPage(page);
    await testArchitectPage.gotoAndClickLogin();
    await loginPage.registerWithEmail();
    await SaveScreenshot(page);
  });
});

