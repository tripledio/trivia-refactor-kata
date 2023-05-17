Run the approval Tests
=========================

Install the necessary dependencies specified in the package.json

    npm install

And execute the test script:

	npm test

The prepared approval tests will be executed. 

Use the TCR script
======================

The TCR script will automatically run the tests and if successful commit them. If the test fail, all your changes will be reverted. This forces you to take many more, much smaller steps :-)

To run the TCR script

On mac

    ./tcr

Depending on how you wish to work, you may need to change the commit script under scripts/commit.sh 

The commit script contains the option for you to work

+ by yourself locally on a branch 
+ pushing immediately to remote repository with pure git 
+ collaborating with others through a remote repo using [mob.sh](https://mob.sh/)

Simply comment out the option you choose.   

