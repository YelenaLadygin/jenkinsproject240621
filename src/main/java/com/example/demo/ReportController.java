package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@RestController

public class ReportController {

        private static ReportDAO reports = new ReportDAO("jdbc:sqlite:C:\\QA\\240621.db");

        @GetMapping("/report")
        public ArrayList<ReportDTO> getReports(){
            ArrayList<ReportDTO> report = reports.getAllReports();
            return report;
        }

        @GetMapping("/report/{Id}")
        public ReportDTO doGetReportById(@PathVariable("Id") int Id)
        {
            ReportDTO report = reports.getReportById(Id);
            return report;
        }

        @PostMapping("/report")
        public void addReport(@RequestBody ReportDTO c)
        {
            reports.insertReport(c);
        }

        @PutMapping("/report/{Id}")
        public void updateReport(@PathVariable("Id") int Id, @RequestBody ReportDTO update_c)
        {
            reports.updateReport(update_c, Id);
        }

        @DeleteMapping("/report/{Id}")
        public void delReportById(@PathVariable("Id") int Id)
        {
            reports.deleteReport(Id);
        }

    }
