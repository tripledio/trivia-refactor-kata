import {describe, it} from 'mocha';
import ApprovalGameRunner from "./approval-game-runner";

import { verify } from 'approvals';

function verifyApprovalData(dataset: number, data: string) {
    verify(__dirname, `approval_data_set_${dataset}`, data, {reporters: [ "gitdiff" ]});
}

function runTestScenario(randomSeed: number): string {
    const gameRunner = new ApprovalGameRunner(randomSeed);
    return gameRunner.runTestScenario();
}

describe('Game Scenario', () => {
    it('should match approval data set 1', () => {
       verifyApprovalData(1, runTestScenario(1));
    });

    it('should match approval data set 2', () => {
        verifyApprovalData(2, runTestScenario(42));
    });

    it('should match approval data set 3', () => {
        verifyApprovalData(3, runTestScenario(13));
    });

    it('should match approval data set 4', () => {
        verifyApprovalData(4, runTestScenario(1337));
    });

    it('should match approval data set 5', () => {
        verifyApprovalData(5, runTestScenario(90));
    });
});
