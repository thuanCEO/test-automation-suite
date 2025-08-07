import { HttpClient } from '@core/HttpClient';
import { ApiEndpoints } from '@testAPI/config/ApiEndpoints';
import { IUser } from '@testAPI/interface/IUser';
import { IHttpRequestOptions } from '@interfaces/IHttpRequestOptions';
import { APIResponse } from '@playwright/test';

export class UserService {
    static async getAll(options?: IHttpRequestOptions): Promise<APIResponse> {
        return await HttpClient.get(ApiEndpoints.users.base, options);
    }

    static async getById(userId: string, options?: IHttpRequestOptions): Promise<APIResponse> {
        return await HttpClient.get(ApiEndpoints.users.byId(userId), options);
    }

    static async create(data: Partial<IUser>, options?: IHttpRequestOptions): Promise<APIResponse> {
        return await HttpClient.post(ApiEndpoints.users.base, {
            ...options,
            body: data,
        });
    }

    static async update(userId: string, data: Partial<IUser>, options?: IHttpRequestOptions): Promise<APIResponse> {
        return await HttpClient.put(ApiEndpoints.users.byId(userId), {
            ...options,
            body: data,
        });
    }

    static async delete(userId: string, options?: IHttpRequestOptions): Promise<APIResponse> {
        return await HttpClient.delete(ApiEndpoints.users.byId(userId), options);
    }
}
