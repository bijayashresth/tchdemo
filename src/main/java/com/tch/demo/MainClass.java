package com.tch.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tch.demo.beans.Bank;

public class MainClass {
	private static List<Bank> bankList = new ArrayList<>();

	public static void main(String... args) {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		MainClass main = new MainClass();

		try {

			System.out.println("CSV file path : ");
			String filePath = br.readLine();

			System.out.println(
					"Search by (Please slelect one of (name | zipcode | state | city | type | cityandstate)  : ");
			String searchBy = br.readLine();
			args = new String[2];

			if (searchBy.equalsIgnoreCase("cityandstate")) {
				System.out.println("Search for city : ");
				args[0] = br.readLine();
				System.out.println("Search for state : ");
				args[1] = br.readLine();
			} else {
				System.out.println("Search for value " + searchBy + " : ");
				args[0] = br.readLine();
			}
			main.readFile(filePath);
			System.out.println(main.search(searchBy, args));
		} catch (Exception ex) {

		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void readFile(String path) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(path));
			sc.nextLine();

			while (sc.hasNextLine()) {
				sc.nextLine().lines().forEach(str -> {
					String[] record = str.split(",");
					Bank bank = new Bank(Integer.parseInt(record[0]), record[1], record[2], record[3], record[4],
							record[5]);
					bankList.add(bank);
				});
			}
		} catch (Exception ex) {
			System.out.println("Error while reading file : " + ex.getMessage());
		} finally {
			if (null != sc) {
				sc.close();
			}
		}

	}

	public List<Bank> search(String key, String[] value) {

		switch (key.toLowerCase()) {
		case "name":
			return searchByName(value[0]);
		case "zipcode":
			return searchByZipCode(value[0]);
		case "state":
			return searchByState(value[0]);
		case "city":
			return searchByCity(value[0]);
		case "type":
			return searchByType(value[0]);
		case "cityandstate":
			return searchByCityAndState(value[0], value[1]);
		default:
			System.out.println("Invalid selection.");
			System.exit(0);
		}
		return null;
	}

	private List<Bank> searchByName(String value) {
		List<Bank> result = new ArrayList<>();
		bankList.forEach(bank -> {
			if (bank.getName().equalsIgnoreCase(value)) {
				result.add(bank);
			}
		});
		return result;
	}

	private List<Bank> searchByZipCode(String value) {
		List<Bank> result = new ArrayList<>();
		bankList.forEach(bank -> {
			if (bank.getZipCode().equalsIgnoreCase(value)) {
				result.add(bank);
			}
		});
		return result;
	}

	private List<Bank> searchByState(String value) {
		List<Bank> result = new ArrayList<>();
		bankList.forEach(bank -> {
			if (bank.getState().equalsIgnoreCase(value)) {
				result.add(bank);
			}
		});
		return result;
	}

	private List<Bank> searchByCity(String value) {
		List<Bank> result = new ArrayList<>();
		bankList.forEach(bank -> {
			if (bank.getCity().equalsIgnoreCase(value)) {
				result.add(bank);
			}
		});
		return result;
	}

	private List<Bank> searchByType(String value) {
		List<Bank> result = new ArrayList<>();
		bankList.forEach(bank -> {
			if (bank.getType().equalsIgnoreCase(value)) {
				result.add(bank);
			}
		});
		return result;
	}

	private List<Bank> searchByCityAndState(String city, String state) {
		List<Bank> result = new ArrayList<>();
		bankList.forEach(bank -> {
			if (bank.getCity().equalsIgnoreCase(city) && bank.getState().equalsIgnoreCase(state)) {
				result.add(bank);
			}
		});
		return result;
	}

	public static List<Bank> getBankList() {
		return bankList;
	}

	public static void setBankList(List<Bank> bankList) {
		MainClass.bankList = bankList;
	}
	
}
