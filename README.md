# LevelingUpRound32
Automatest: Test Automation training round 32 practice project


## Element Identification
```
absolute xpath
/html/body/div/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[1]/a/img

relative xpath
//*[@id="__next"]/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[1]/a/img

x^17

Golden Formula:
//tagName[@attribute='value']

Variations:
//tagName[@attribute]
//tagName[@attribute1='value1'][@attribute2='value2']

//tagName[@attribute='value']/childElement
//tagName[@attribute='value']//grandChildElement

(//tagName[@attribute='value'])[index]

//tagName[@attribute='value']
//tagName[contains(@attribute,'subsetValue')]

//*[@attribute='value']

Golden Rules:
- locators must always satisfy your business requirements
- follow the formula
- use unique attributes, and unique values (not generic ones)
- use a locator that will match ONLY ONE ELEMENT
- never use the index unless explicitly stated in your business requirements
```

## Test Workflow Management

### Test Cases:
- test cases are independent
- use before/after method for setup/teardown
- starts with navigation
- user performs some actions (not many)
- ends with assertion
- has one checkpoint
- multiple test cases per java class, one class per business module (ex: loginTests, registrationTests)
- all tests can exist in the same package

### Test Scenarios:
- you cannot create it in one test method (multiple reasons for failure)
- test methods are dependent on each other (dependsOnMethods)
- the order of execution is not important (never use priority)
- each test method represents a validatable business action, one action and one checkpoint
- they share a common setup and teardown (before/after class)
- one class per test scenario (ex: checkOrderIsCompletedViaCreditCardPayment, checkOrderIsCompletedViaCashPayment)
- one package per business scope (ex: sanity tests, regression tests, client tests)
