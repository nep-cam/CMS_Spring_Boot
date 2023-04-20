package com.hivetech.services;

import com.hivetech.entities.Content;
import com.hivetech.repositories.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class ContentServices {
    @Autowired
    private ContentRepository contentRepository;

    public Content createContent(Content content) {
        return contentRepository.save(content);
    }

    public List<Content> getAllContent() {
        return contentRepository.findAll();
    }

    public Content getContentById(long id) {
        return contentRepository.findById(id).orElse(null);
    }

    public void deleteMember(Long id) {
        contentRepository.deleteById(id);
    }
}
