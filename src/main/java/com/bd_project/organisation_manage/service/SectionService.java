package com.bd_project.organisation_manage.service;

import java.util.List;

import com.bd_project.organisation_manage.model.SectionIdClass;
import com.bd_project.organisation_manage.model.Section;

public interface SectionService {
	public Section createSection(String section_name);
	public Section createSection(Section section);
	public List<Section> indexSection();
	public Section findSection(Integer section_id, String section_name);
    public Section findSection(SectionIdClass sectionIdClass);
    public Section deleteSection(Integer section_id, String section_name);
    public Section deleteSection(SectionIdClass sectionIdClass);
    public void deleteAllSection();
}
