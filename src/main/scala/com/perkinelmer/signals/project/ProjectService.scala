package com.perkinelmer.signals.project

import com.perkinelmer.signals.dataset.Dataset

class ProjectService() {

	def getProject(descriptorId: String): Project = {
		return Project("x.1", "x", "mock project")
	}
}