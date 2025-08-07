export const ApiEndpoints = {
    users: {
        base: '/api/v2/user',
        byId: (id: string) => `/api/v2/user/${id}`,
    }
};