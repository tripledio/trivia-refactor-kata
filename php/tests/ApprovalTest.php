<?php

declare(strict_types=1);

require_once 'Presenter.php';
require_once 'ApprovalGameRunner.php';
require_once 'Game.php';

use ApprovalTests\Approvals;
use PHPUnit\Framework\TestCase;

class ApprovalTest extends TestCase
{
    public function __construct(?string $name = null, array $data = [], $dataName = '')
    {
        parent::__construct($name, $data, $dataName);
    }

    public function testApprovalScenario1(): void
    {
        $this->approvalScenario(13);
    }

    public function testApprovalScenario2(): void
    {
        $this->approvalScenario(17);
    }

    public function testApprovalScenario3(): void
    {
        $this->approvalScenario(31);
    }

    /**
     * @param int $randomSeed
     * @return void
     */
    public function approvalScenario(int $randomSeed): void
    {
        $p = new ApprovalGameRunner();
        $p->runTestScenario($randomSeed);
        $outputData = $p->getOutputData();
        Approvals::verifyString($outputData);
    }


}

