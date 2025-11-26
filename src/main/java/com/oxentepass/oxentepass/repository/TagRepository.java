package com.oxentepass.oxentepass.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

import com.oxentepass.oxentepass.entity.QTag;
import com.oxentepass.oxentepass.entity.Tag;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>, // -> JpaRepository já herda de PagingAndSortingRepository
                                        QuerydslPredicateExecutor<Tag>, 
                                        QuerydslBinderCustomizer<QTag> {
    
    Optional<Tag> findByTag(String tag); // Find exato
                                        
    @Override
    default void customize(QuerydslBindings bindings, QTag root) {
        // Bind para atributo tag
        bindings.bind(root.tag).first((StringPath path, String value) -> path.containsIgnoreCase(value));

        // Bind para id
        bindings.bind(root.id).first((NumberPath<Long> path, Long value) -> path.eq(value));
    }
}
