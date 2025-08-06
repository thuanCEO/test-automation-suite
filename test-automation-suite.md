test-automation-suite/
│
├── README.md                     # Giới thiệu project, cách chạy từng phần
├── .gitignore
├── pom.xml / package.json       # Quản lý dependencies (Java/Node)
│
├── config/                      # Thư mục chứa config chung
│   ├── env/                     # Cấu hình môi trường test
│   └── global.properties
│
├── reports/                     # Thư mục chứa báo cáo test (allure, html, etc.)
│
├── tools/                       # Script tiện ích (convert data, DB tool, ...)
│
├── test-ui/
│   ├── selenium/                # Selenium tests
│   │   ├── tests/
│   │   ├── pages/
│   │   ├── drivers/
│   │   └── pom.xml
│   └── playwright/              # Playwright tests
│       ├── tests/
│       ├── pages/
│       ├── locators/
│       └── playwright.config.ts
│
├── test-api/
│   ├── karate/                  # Karate tests
│   │   ├── features/
│   │   ├── data/
│   │   └── karate-config.js
│   ├── postman/                 # Postman collections (Newman)
│   │   └── *.json
│   └── rest-assured/            # REST Assured (Java)
│       ├── tests/
│       └── pom.xml
│
├── test-performance/
│   ├── jmeter/                  # Apache JMeter scripts
│   │   └── *.jmx
│   └── k6/                      # k6 scripts (JS)
│       └── *.js
│
├── test-mobile/
│   ├── appium/                  # Appium tests
│   │   ├── android/
│   │   └── ios/
│   └── maestro/                 # Maestro YAML scripts
│       └── *.yaml
│
└── .github/
    └── workflows/              # GitHub Actions CI pipelines
        └── run-tests.yml
