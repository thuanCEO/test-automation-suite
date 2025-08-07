playwright/
├── src/
│   ├── config/
│   │   └── envConfig.ts             # Load & parse ENV (dev, staging, etc.)
│   ├── constants/
│   │   └── httpStatus.ts
│   ├── enums/
│   │   └── EnvEnum.ts
│   ├── helpers/
│   │   └── responseValidator.ts     # Validate schema/status/body
│   ├── services/
│   │   ├── auth.service.ts
│   │   └── user.service.ts
│   ├── test-api/
│   │   ├── tests/
│   │   │   └── userAPI.spec.ts
│   │   └── features/
│   │       └── register.feature     # Optional: BDD support
│   ├── types/
│   │   └── user.d.ts                # Type definitions for API responses
│   └── utils/
│       └── request.ts               # Wrapper over `request.newContext()`
├── tests/
│   └── api.config.ts                # API-specific config (project, retries)
├── .env.dev                         # env files
├── .env.staging
├── playwright.config.ts
├── tsconfig.json
└── package.json
