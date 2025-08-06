├── src/
│   ├── core/
│   │   ├── ApiClient.ts         # Gửi request
│   │   ├── ApiContext.ts        # Context đa môi trường
│   │   ├── TokenManager.ts      # Quản lý bearer/refresh
│   │   └── Interceptor.ts       # Logging & hooks
│   │
│   ├── services/
│   │   ├── AuthService.ts       # Service gọi API Auth
│   │   └── UserService.ts       # Ví dụ thêm
│   │
│   ├── config/
│   │   └── index.ts             # Cấu hình theo ENV
│   │
│   ├── types/
│   │   ├── ApiTypes.ts
│   │   └── PayloadTypes.ts
│   │
│   ├── utils/
│   │   └── Logger.ts            # Màu sắc, cấp độ log
│   │
│   └── index.ts                 # Public API
│
├── tests/
│   └── example.spec.ts
│
├── .env
├── package.json
├── tsconfig.json
├── README.md
