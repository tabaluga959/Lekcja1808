package lambda;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;

class LambdaTypesTest {
    @org.junit.Test
    public void beforeLambda() {
        LambdaTypes lambdaTypes = new LambdaTypes();
        lambdaTypes.createString();
        String string1 = lambdaTypes.createString();
        String string2 = string1.toUpperCase();
        String string3 = string2.replaceAll("", "");
        String string4 = parseToEmoji(string3);
        System.out.println(string4);
        // given

        //when

        // then
    }

    private String parseToEmoji(String text) {
        return text.replaceAll(":D","x6458");
    }

    @Test
    public void shouldName() {
       Function<LambdaTypes,String> mapper = (LambdaTypes lambdatypes) -> lambdatypes.createString();
       Function<LambdaTypes,String> mapper2 = LambdaTypes::createString;
       Optional.of(new LambdaTypes()).map(LambdaTypes::createString).map((String string)->string.toUpperCase());

    }


}