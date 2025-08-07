import { test } from '@playwright/test';
import { HttpClient } from '@core/HttpClient';
import { UserService } from '@testAPI/services/UserService';
import { BaseURL } from '@testAPI/config/BaseURL';
import { TokenTypeEnums } from '@enums/TokenTypeEnum';
import { ContentTypeEnum } from '@enums/ContentTypeEnum';

let createdUserId: string;

test.describe.parallel('@Smoke @UserAPI', () => {

    test.beforeAll(async () => {
        await HttpClient.init(BaseURL.MockAPI);
    });


    test('Get all users with query params', async () => {
        const response = await UserService.getAll({
            auth: true,
            tokenType: TokenTypeEnums.Bearer,
            params: {
                page: 1,
                limit: 5
            },
        });

        await HttpClient.assertStatus(response, 200);
        const users = await HttpClient.getJson(response);
        console.log(users);
    });

});
