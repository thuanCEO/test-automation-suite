import { test } from '@playwright/test';
import { HttpClient } from '@core/HttpClient';
import { UserService } from '@testAPI/services/UserService';
import { BaseURL } from '@testAPI/config/BaseURL';
import { TokenTypeEnums } from '@enums/TokenTypeEnum';
import { Logger } from '@utils/LoggerUtils';

let createdUserId: string;

test.describe.parallel('@Smoke @UserAPI', () => {

    test.beforeAll(async () => {
        await HttpClient.init(BaseURL.MockAPI);
    });


    test('Get all users with query params', async () => {
        Logger.info('🔍 Starting test: Get all users with query params');

        const queryParams = {
            page: 1,
            limit: 5
        };
        Logger.debug(`➡ Sending request with query params: ${JSON.stringify(queryParams)}`);

        const response = await UserService.getAll({
            auth: true,
            tokenType: TokenTypeEnums.Bearer,
            params: queryParams,
        });

        Logger.info(`✅ Received response with status: ${response.status()}`);
        await HttpClient.assertStatus(response, 200);

        const users = await HttpClient.getJson(response);
        Logger.debug(`📦 Response JSON: ${JSON.stringify(users, null, 2)}`);

        Logger.info(`👥 Total users received: ${users.length}`);
    });

});
