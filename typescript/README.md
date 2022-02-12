Trivia kata in typescript
=========================

1. Install the dependencies with this command: `npm install`
2. Run the game with this command: `npm run start`
3. Run the tests with this command: `npm test`

    Any test source matching the pattern `*.test.ts` below `tests/` will be executed.


## Windows issues

You might have an issue where the approval tests are failing on windows.
This has to do with line endings and can be easily fixed by running the following commands in **git bash**:

```
unix2dos tests/*.approved.txt
git add tests/*.approved.txt
```

These commands will force git to use CRLF line endings for the approved tests, indepedent of what your `core.autocrlf` settings are set to and without having to check a `.gitattributes` file.
