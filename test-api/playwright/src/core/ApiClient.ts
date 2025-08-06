// src/core/ApiClient.ts
import { getApiContext } from './ApiContext';
import { ApiRequestParams, ApiResponse } from '../types/ApiTypes';
import { interceptRequest, interceptResponse } from './Interceptor';

export class ApiClient {
    async request<T = any>({ method, endpoint, payload, headers }: ApiRequestParams): Promise<ApiResponse<T>> {
        const context = await getApiContext();

        interceptRequest(method, endpoint, payload); // Hook

        const response = await context.fetch(endpoint, {
            method,
            data: payload,
            headers,
        });

        const status = response.status();
        const body = await response.json().catch(() => ({}));

        interceptResponse(method, endpoint, status); // Hook

        return { status, body };
    }

    get<T>(endpoint: string, headers?: Record<string, string>) { ... }
    post<T>(...) { ... }
    // etc.
}
