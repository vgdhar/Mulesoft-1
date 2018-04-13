%dw 1.0
%output application/java
---
[{
	construction: "????",
	county: "????",
	eq_site_deductible: 2,
	eq_site_limit: 2,
	fl_site_deductible: 2,
	fl_site_limit: 2,
	fr_site_deductible: 2,
	fr_site_limit: 2,
	hu_site_deductible: 2,
	hu_site_limit: 2,
	line: "????",
	point_granularity: 1,
	point_latitude: 2,
	point_longitude: 2,
	policyID: 1,
	statecode: "????",
	tiv_2011: 2,
	tiv_2012: 2
} as :object {
	class : "diablo.batch.Batch"
}]