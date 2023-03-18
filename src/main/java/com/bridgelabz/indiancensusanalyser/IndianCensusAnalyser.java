package com.bridgelabz.indiancensusanalyser;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class IndianCensusAnalyser {
    public static List<IndianCensusData> indianCensusList = new ArrayList<>();
    public static List<StateCsv> stateCodeList = new ArrayList<>();
    public static int i = 0;

    public int loadCensusData(String filePath) throws Exception{
        try{
            indianCensusList = new ArrayList<>();
            CSVReader reader = new CSVReader(new FileReader(filePath));
            List<String[]> data = reader.readAll();
            data.stream().forEach(n->{
                Iterator<String> iterate = Arrays.stream(n).iterator();
                String state = iterate.next();
                String population = iterate.next();
                String areaInSqKm = iterate.next();
                String densityPerSqKm = iterate.next();
                if(!population.equals("Population"))
                    indianCensusList.add(new IndianCensusData(state, Long.parseLong(population), Long.parseLong(areaInSqKm), Integer.parseInt(densityPerSqKm)));
            });
            reader.close();
        }catch(FileNotFoundException e) {
            throw new CustomException(e.getMessage(),CustomException.ExceptionType.File_Not_Found);
        }
        catch(IllegalStateException  e) {
            throw new CustomException(e.getMessage(),CustomException.ExceptionType.Parse_Error);
        }
        return indianCensusList.size();
    }

    public int loadStateData(String filePath) throws Exception{
        try{
            i = 0;
            stateCodeList = new ArrayList<>();
            CSVReader reader = new CSVReader(new FileReader(filePath));
            List<String[]> data = reader.readAll();
            data.stream().forEach(n->{
                Iterator<String> iterate = Arrays.stream(n).iterator();
                String srNo = iterate.next();
                String state = iterate.next();
                String TIN = iterate.next();
                String stateCode = iterate.next();
                if(i == 0)
                    i=1;
                else
                    stateCodeList.add(new StateCsv(Integer.valueOf(srNo),state,Integer.valueOf(TIN),stateCode));
            });
            reader.close();
        }catch(FileNotFoundException e) {
            throw new CustomException(e.getMessage(),CustomException.ExceptionType.File_Not_Found);
        }
        catch(IllegalStateException  e) {
            throw new CustomException(e.getMessage(),CustomException.ExceptionType.Parse_Error);
        }
        return stateCodeList.size();
    }
}
