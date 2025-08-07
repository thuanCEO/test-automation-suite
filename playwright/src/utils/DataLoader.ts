import fs from 'fs';
import path from 'path';
import { PlatForm } from '@constants/Platform';
import { Project } from '@testUI/resources/Project';

export class DataLoader {

    public static loadFileNameData(filename: string): any {
        const envLang = `${PlatForm.environment}_${PlatForm.language}`;
        const startDir = path.resolve(__dirname, '../test-ui/resources');
        const filePath = this.findFileRecursive(startDir, filename);

        if (!filePath) {
            throw new Error(`Test data not found (searched recursively): ${filename}`);
        }

        const rawData = fs.readFileSync(filePath, 'utf-8');
        const parsedData = JSON.parse(rawData);

        return parsedData[envLang];
    }


    public static loadFileName(filename: string): any {
        const envLang = `${PlatForm.environment}_${PlatForm.language}`;
        const fullPath = path.resolve(__dirname, '../test-ui/resources/testdata', envLang, Project.Project, filename);

        if (!fs.existsSync(fullPath)) {
            throw new Error(`Test data not found: ${fullPath}`);
        }

        const rawData = fs.readFileSync(fullPath, 'utf-8');
        const parsedData = JSON.parse(rawData);

        return parsedData;
    }

    private static findFileRecursive(dir: string, targetFile: string): string | undefined {
        const entries = fs.readdirSync(dir, { withFileTypes: true });

        for (const entry of entries) {
            const fullPath = path.join(dir, entry.name);

            if (entry.isDirectory()) {
                const result = this.findFileRecursive(fullPath, targetFile);
                if (result) return result;
            } else if (entry.name === targetFile) {
                return fullPath;
            }
        }

        return undefined;
    }
}
