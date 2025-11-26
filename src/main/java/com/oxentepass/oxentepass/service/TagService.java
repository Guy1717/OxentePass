package com.oxentepass.oxentepass.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.oxentepass.oxentepass.entity.Tag;
import com.querydsl.core.types.Predicate;

public interface TagService {
    public void criarTag(Tag tag);
    public Page<Tag> listarTags (Pageable pageable);
    public Page<Tag> listarTagsFiltro (Predicate predicate, Pageable pageable);
    public void deletarTag(long id);
}
