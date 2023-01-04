package fixxy.core;

import fixxy.core.exceptions.UnsupportedTagNumberException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fixxy.core.AbstractFieldDefinitionRepositoryKotlinTest.*;
import static fixxy.core.standard.StandardFieldDefinition.simpleFieldDefinition;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName(JavaSuiteName)
class AbstractFieldDefinitionRepositoryJavaTest {

  @Test
  @DisplayName(NullOrThrowingTestName)
  public void testNullOrThrowing() {
    final TestFieldDefinitionRepository repo = new TestFieldDefinitionRepository(true);
    assertThrows(UnsupportedTagNumberException.class, () -> repo.fieldDefinitionOrThrowForTagNumber(54));
    assertNull(repo.fieldDefinitionOrNullForTagNumber(54));
  }

  @Test
  @DisplayName(NotNullAndNotThrowingTestName)
  public void testNotNullAndNotThrowing() {
    final TestFieldDefinitionRepository repo = new TestFieldDefinitionRepository(false);
    assertEquals(54, repo.fieldDefinitionOrThrowForTagNumber(54).getTagNumber());
    assertEquals(54, repo.fieldDefinitionOrNullForTagNumber(54).getTagNumber());
  }

  private static class TestFieldDefinitionRepository extends AbstractFieldDefinitionRepository {

    private final boolean throwing;

    private TestFieldDefinitionRepository(final boolean throwing) {
      this.throwing = throwing;
    }

    @NotNull
    @Override
    public FieldDefinition fieldDefinitionOrThrowForTagNumber(int tagNumber) throws UnsupportedTagNumberException {
      if (throwing) {
        throw new UnsupportedTagNumberException(tagNumber);
      } else {
        return simpleFieldDefinition(tagNumber, String.format("Field [%s]", tagNumber));
      }
    }
  }
}
