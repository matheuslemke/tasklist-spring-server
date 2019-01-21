package com.lemke.tasklist.exception;

import javax.persistence.NoResultException;

public class NotFoundException extends NoResultException {

  public NotFoundException(Long id) {
    super("Entity with id " + id + " not found.");
  }

}
