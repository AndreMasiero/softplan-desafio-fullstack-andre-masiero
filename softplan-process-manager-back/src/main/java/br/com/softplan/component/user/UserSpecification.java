package br.com.softplan.component.user;

import br.com.softplan.domain.Role_;
import br.com.softplan.domain.User;
import br.com.softplan.domain.User_;
import br.com.softplan.enums.RoleUser;
import org.springframework.data.jpa.domain.Specification;

import static org.springframework.data.jpa.domain.Specification.where;

public class UserSpecification {
    public static Specification<User> findByFilter(RoleUser roleUser) {

        Specification<User> where = where(null);
        Specification<User> whereOR = where(null);

        if (roleUser.equals(RoleUser.ROLE_TRIATOR))
            where = where.and(whereOR.or(roleEquals(RoleUser.ROLE_TRIATOR)).or(roleEquals(RoleUser.ROLE_FINISHER)));

        return where;
    }

    public static Specification<User> roleEquals(final RoleUser value) {
        return (root, query, cb) -> {
            return cb.equal(root.join(User_.role).get(Role_.name), value);
        };
    }
}
