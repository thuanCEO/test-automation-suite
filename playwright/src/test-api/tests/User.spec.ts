import { test, expect } from '@playwright/test';
import { HttpClient } from '@core/HttpClient';
import { UserService } from '@testAPI/services/UserService';
import { BaseURL } from '@testAPI/config/BaseURL';
import { TokenTypeEnums } from '@enums/TokenTypeEnum';
import { Logger } from '@utils/LoggerUtils';
import { IUser } from '@testAPI/interface/IUser';
import { RandomEmail, RandomPhoneNumber, RandomAddress } from '@utils/RandomData';

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

    test('Create user', async () => {
        const userData: Partial<IUser> = {
            userName: 'Anh Thuan Dz',
            userAddress: RandomAddress(),
            userPhone: RandomPhoneNumber(),
            userEmail: RandomEmail(),
            userSubject: {},
            isActive: true,
            userBir: 1753237995,
        };

        Logger.info('➕ Creating new user...');
        const response = await UserService.create(userData, {
            auth: true,
            tokenType: TokenTypeEnums.Bearer,
        });

        await HttpClient.assertStatus(response, 201);
        const created = await HttpClient.getJson(response);
        Logger.debug(`🆕 Created user: ${JSON.stringify(created, null, 2)}`);

        createdUserId = created.userId;
        expect(created.userName).toBe(userData.userName);
    });

    test('Get user by ID', async () => {
        Logger.info(`🔍 Getting user by ID: ${createdUserId}`);
        const response = await UserService.getById(createdUserId, {
            auth: true,
            tokenType: TokenTypeEnums.Bearer,
        });

        await HttpClient.assertStatus(response, 200);
        const user = await HttpClient.getJson(response);
        Logger.debug(`📦 User info: ${JSON.stringify(user, null, 2)}`);

        expect(user.userId).toBe(createdUserId);
    });

    test('Update user by ID', async () => {
        const updatedData: Partial<IUser> = {
            userName: 'Updated Thuan',
            userAddress: 'Ha Noi',
        };

        Logger.info(`✏️ Updating user ID ${createdUserId}`);
        const response = await UserService.update(createdUserId, updatedData, {
            auth: true,
            tokenType: TokenTypeEnums.Bearer,
        });

        await HttpClient.assertStatus(response, 200);
        const updated = await HttpClient.getJson(response);
        Logger.debug(`✅ Updated user: ${JSON.stringify(updated, null, 2)}`);

        expect(updated.userName).toBe(updatedData.userName);
    });

    // test('Delete user by ID', async () => {
    //     Logger.info(`🗑️ Deleting user ID ${createdUserId}`);
    //     const response = await UserService.delete(createdUserId, {
    //         auth: true,
    //         tokenType: TokenTypeEnums.Bearer,
    //     });

    //     await HttpClient.assertStatus(response, 200);
    //     Logger.info(`✅ Deleted user ${createdUserId} successfully`);
    // });

});
