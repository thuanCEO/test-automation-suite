// src/constants/HttpStatuses.ts
import { IHttpStatus } from '@interfaces/IHttpStatus';
import { StatusDescriptions } from '@constants/StatusDescriptions';
import { StatusCategories } from '@constants/StatusCategories';
import { StatusSeverities } from '@constants/StatusSeverities';
import { StatusContexts } from '@constants/StatusContexts';
import { StatusTexts } from '@constants/StatusTexts';

export const HttpStatuses: Record<number, IHttpStatus> = {
    200: {
        code: 200,
        text: StatusTexts[200],
        description: StatusDescriptions[200],
        category: StatusCategories[200],
        severity: StatusSeverities[200],
        context: StatusContexts[200],
    },
    201: {
        code: 201,
        text: StatusTexts[201],
        description: StatusDescriptions[201],
        category: StatusCategories[201],
        severity: StatusSeverities[201],
        context: StatusContexts[201],
    },
    202: {
        code: 202,
        text: StatusTexts[202],
        description: StatusDescriptions[202],
        category: StatusCategories[202],
        severity: StatusSeverities[202],
        context: StatusContexts[202],
    },
    204: {
        code: 204,
        text: StatusTexts[204],
        description: StatusDescriptions[204],
        category: StatusCategories[204],
        severity: StatusSeverities[204],
        context: StatusContexts[204],
    },

    400: {
        code: 400,
        text: StatusTexts[400],
        description: StatusDescriptions[400],
        category: StatusCategories[400],
        severity: StatusSeverities[400],
        context: StatusContexts[400],
    },
    401: {
        code: 401,
        text: StatusTexts[401],
        description: StatusDescriptions[401],
        category: StatusCategories[401],
        severity: StatusSeverities[401],
        context: StatusContexts[401],
    },
    403: {
        code: 403,
        text: StatusTexts[403],
        description: StatusDescriptions[403],
        category: StatusCategories[403],
        severity: StatusSeverities[403],
        context: StatusContexts[403],
    },
    404: {
        code: 404,
        text: StatusTexts[404],
        description: StatusDescriptions[404],
        category: StatusCategories[404],
        severity: StatusSeverities[404],
        context: StatusContexts[404],
    },
    405: {
        code: 405,
        text: StatusTexts[405],
        description: StatusDescriptions[405],
        category: StatusCategories[405],
        severity: StatusSeverities[405],
        context: StatusContexts[405],
    },
    409: {
        code: 409,
        text: StatusTexts[409],
        description: StatusDescriptions[409],
        category: StatusCategories[409],
        severity: StatusSeverities[409],
        context: StatusContexts[409],
    },
    422: {
        code: 422,
        text: StatusTexts[422],
        description: StatusDescriptions[422],
        category: StatusCategories[422],
        severity: StatusSeverities[422],
        context: StatusContexts[422],
    },

    500: {
        code: 500,
        text: StatusTexts[500],
        description: StatusDescriptions[500],
        category: StatusCategories[500],
        severity: StatusSeverities[500],
        context: StatusContexts[500],
        isRetryable: true,
    },
    501: {
        code: 501,
        text: StatusTexts[501],
        description: StatusDescriptions[501],
        category: StatusCategories[501],
        severity: StatusSeverities[501],
        context: StatusContexts[501],
    },
    502: {
        code: 502,
        text: StatusTexts[502],
        description: StatusDescriptions[502],
        category: StatusCategories[502],
        severity: StatusSeverities[502],
        context: StatusContexts[502],
        isRetryable: true,
    },
    503: {
        code: 503,
        text: StatusTexts[503],
        description: StatusDescriptions[503],
        category: StatusCategories[503],
        severity: StatusSeverities[503],
        context: StatusContexts[503],
        isRetryable: true,
    },
    504: {
        code: 504,
        text: StatusTexts[504],
        description: StatusDescriptions[504],
        category: StatusCategories[504],
        severity: StatusSeverities[504],
        context: StatusContexts[504],
        isRetryable: true,
    },
};
