package com.fullcycle.FCCatalogo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CastMemberTests {

  @Test
  public void throwIllegalArgumentExceptionWhenNameIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new CastMember(null));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenNameIsEmpty() {
    assertThrows(IllegalArgumentException.class, () -> new CastMember(""));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenNameIsNullAndTypeIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new CastMember(null, null));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenNameIsEmptyAndTypeIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new CastMember("", null));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenTypeIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new CastMember("CastMamber1", null));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenTypeIsNotValid() throws IllegalArgumentException {
    assertThrows(IllegalArgumentException.class, () -> {
      CastMember castMember = mock(CastMember.class);
      castMember.setName("Talison");

      doThrow(IllegalArgumentException.class).when(castMember).setType(CastMemberType.TYPE2);
      castMember.setType(CastMemberType.TYPE2);
    });
  }

  @Test
  public void createCastMemberWithNameTest() {
    final CastMember castMember = new CastMember("Talison");

    assertNotNull(castMember);
    assertEquals(castMember.getName(), "Talison");
    assertTrue(castMember.isValidUUID(castMember.getId().toString()));
    assertNull(castMember.getType());
  }

  @Test
  @EnumSource(value = CastMemberType.class)
  public void createCastMemberWithNameAndTypeTest() {
    final CastMember castMember = new CastMember("Talison", CastMemberType.TYPE1);

    assertNotNull(castMember);
    assertEquals(castMember.getName(), "Talison");
    assertTrue(castMember.isValidUUID(castMember.getId().toString()));
    assertTrue(CastMemberType.valueOf(castMember.getType()));
    assertEquals(castMember.getType(), CastMemberType.TYPE1);

  }

}
