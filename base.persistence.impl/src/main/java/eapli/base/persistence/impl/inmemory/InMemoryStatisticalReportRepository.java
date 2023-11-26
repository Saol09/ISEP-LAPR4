package eapli.base.persistence.impl.inmemory;

import eapli.base.questionnaires.domain.QuestionnaireString;
import eapli.base.questionnaires.domain.StatisticalReport;
import eapli.base.questionnaires.repository.StatisticalReportRepository;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryStatisticalReportRepository extends InMemoryDomainRepository<StatisticalReport, Long> implements StatisticalReportRepository {

    static {
        InMemoryInitializer.init();
    }
}
