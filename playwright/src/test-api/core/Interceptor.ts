import chalk from 'chalk';

export function interceptRequest(method: string, endpoint: string, payload: any) {
    console.log(chalk.cyan(`[REQUEST] ${method} ${endpoint}`));
    if (payload) console.log(chalk.gray(JSON.stringify(payload, null, 2)));
}

export function interceptResponse(method: string, endpoint: string, status: number) {
    const statusColor = status >= 200 && status < 300 ? chalk.green : chalk.red;
    console.log(statusColor(`[RESPONSE] ${method} ${endpoint} -> ${status}`));
}
