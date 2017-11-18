package br.com.lilianyfotografia.jpa.annotations;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;

@Retention(RUNTIME)
@Stereotype
@Transactional
@ApplicationScoped
public @interface Repository
{
}