test-automation-suite/
│
├── README.md                      # Giới thiệu project, cách chạy từng phần
├── .gitignore
├── pom.xml / package.json         # Quản lý dependencies (Java/Node)
│
├── config/                        # Thư mục chứa config chung
│   ├── env/                       # Cấu hình môi trường test
│   └── global.properties
│
├── reports/                       # Thư mục chứa báo cáo test (Allure, HTML, etc.)
│
├── tools/                         # Scripts tiện ích (convert data, DB tool, ...)
│
├── test-ui/                       # Kiểm thử giao diện (UI Tests)
│   ├── selenium/                  # Selenium tests
│   │   ├── tests/
│   │   ├── pages/
│   │   ├── drivers/
│   │   └── pom.xml
│   └── playwright/                # Playwright tests
│       ├── tests/
│       ├── pages/
│       ├── locators/
│       └── playwright.config.ts
│
├── test-api/                      # Kiểm thử API (REST)
│   ├── karate/                    # Karate tests
│   │   ├── features/
│   │   ├── data/
│   │   └── karate-config.js
│   ├── postman/                   # Postman collections (Newman)
│   │   └── *.json
│   └── rest-assured/              # REST Assured (Java)
│       ├── tests/
│       └── pom.xml
│
├── test-performance/              # Kiểm thử hiệu năng (Performance)
│   ├── jmeter/                    # Apache JMeter scripts
│   │   └── *.jmx
│   └── k6/                        # k6 scripts (JavaScript)
│       └── *.js
│
├── test-mobile/                   # Kiểm thử mobile app
│   ├── appium/                    # Appium tests
│   │   ├── android/
│   │   └── ios/
│   └── maestro/                   # Maestro YAML scripts
│       └── *.yaml
│
└── .github/                       # GitHub CI/CD
    └── workflows/
        └── run-tests.yml         # Pipeline CI chạy automation test
