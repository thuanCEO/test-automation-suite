// src/common/api.ts
import { request } from '@playwright/test';
import { ApiConfig } from '@config/ApiConfig';

export async function sendAPIRequest({
    method,
    endpoint,
    payload,
    headers = {},
}: {
    method: 'GET' | 'POST' | 'PUT' | 'DELETE',
    endpoint: string,
    payload?: any,
    headers?: Record<string, string>
}) {
    const context = await request.newContext({
        baseURL: ApiConfig.baseURL,
        extraHTTPHeaders: {
            ...ApiConfig.defaultHeaders,
            ...headers,
        },
    });

    const response = await context.fetch(endpoint, {
        method,
        data: payload,
    });

    const status = response.status();
    const body = await response.json().catch(() => ({}));

    return { status, body };
}
