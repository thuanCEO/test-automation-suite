let token = '';

export function setToken(t: string) {
    token = t;
}

export function getToken() {
    return token;
}

export function getAuthHeader() {
    return token ? { Authorization: `Bearer ${token}` } : {};
}
