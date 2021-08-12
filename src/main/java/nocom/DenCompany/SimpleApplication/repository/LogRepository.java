package nocom.DenCompany.SimpleApplication.repository;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import nocom.DenCompany.SimpleApplication.entity.Log;
import nocom.DenCompany.SimpleApplication.entity.QLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

import java.util.UUID;

public interface LogRepository extends JpaRepository<Log, UUID>,
        QuerydslPredicateExecutor<Log>, QuerydslBinderCustomizer<QLog> {
    @Override
    default public void customize(
            QuerydslBindings bindings, QLog root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
//        bindings.excluding(root.date);
    }
}
