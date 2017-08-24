package com.example.service;

import java.util.List;

import com.example.domin.Cele;
import com.example.domin.Result;

public interface OracleResult {
	List<Result> findResult() throws Exception;

	List<Cele> findCele() throws Exception;
}
