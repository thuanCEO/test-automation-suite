import { ApiClient } from '../test-api/core/ApiClient';
import { setToken } from '../test-api/core/TokenManager';

const api = new ApiClient();

export async function login(email: string, password: string) {
    const res = await api.post('/auth/login', { email, password });

    if (res.status === 200 && res.body.token) {
        setToken(res.body.token);
    }

    return res;
}
