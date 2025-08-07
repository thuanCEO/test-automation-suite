import { HttpClient } from '@core/HttpClient';
import { ApiEndpoints } from '@testAPI/config/ApiEndpoints';
import { IUser } from '@testAPI/interface/IUser';
import { IHttpRequestOptions } from '@interfaces/IHttpRequestOptions';
import { APIResponse } from '@playwright/test';
import { Logger } from '@utils/LoggerUtils';

export class UserService {
    static async getAll(options?: IHttpRequestOptions): Promise<APIResponse> {
        Logger.info('[UserService] 📥 Fetching all users');
        return await HttpClient.get(ApiEndpoints.users.base, options);
    }

    static async getById(userId: string, options?: IHttpRequestOptions): Promise<APIResponse> {
        Logger.info(`[UserService] 🔍 Fetching user by ID: ${userId}`);
        return await HttpClient.get(ApiEndpoints.users.byId(userId), options);
    }

    static async create(data: Partial<IUser>, options?: IHttpRequestOptions): Promise<APIResponse> {
        Logger.info(`[UserService] ➕ Creating user with data: ${JSON.stringify(data)}`);
        return await HttpClient.post(ApiEndpoints.users.base, {
            ...options,
            body: data,
        });
    }

    static async update(userId: string, data: Partial<IUser>, options?: IHttpRequestOptions): Promise<APIResponse> {
        Logger.info(`[UserService] ✏️ Updating user ID ${userId} with data: ${JSON.stringify(data)}`);
        return await HttpClient.put(ApiEndpoints.users.byId(userId), {
            ...options,
            body: data,
        });
    }

    static async delete(userId: string, options?: IHttpRequestOptions): Promise<APIResponse> {
        Logger.info(`[UserService] 🗑️ Deleting user with ID: ${userId}`);
        return await HttpClient.delete(ApiEndpoints.users.byId(userId), options);
    }
}
