package eapli.base.persistence.impl.inmemory;

import eapli.base.questionnaires.domain.Answer;

import eapli.base.questionnaires.repository.AnswerRepository;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAnswerRepository extends InMemoryDomainRepository<Answer,String> implements AnswerRepository {
    static {
        InMemoryInitializer.init();
    }
}
