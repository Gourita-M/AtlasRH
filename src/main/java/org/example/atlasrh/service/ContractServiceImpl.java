package org.example.atlasrh.service;

import org.example.atlasrh.dto.ContractResponseDTO;
import org.example.atlasrh.mapper.ContractMapper;
import org.example.atlasrh.model.Contract;
import org.example.atlasrh.model.Employee;
import org.example.atlasrh.repository.ContractRepository;
import org.example.atlasrh.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService{
    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;
    private final EmployeeService employeeService;

    public ContractServiceImpl(ContractRepository contractRepository,
                               ContractMapper contractMapper,
                               EmployeeService employeeService){
        this.contractRepository = contractRepository;
        this.contractMapper = contractMapper;
        this.employeeService = employeeService;
    }

    @Override
    public ContractResponseDTO create(Contract contract, Long id){
        Employee employee = employeeService.viewEmployee(id);
        System.out.println(employee.getMatricule());
        if(employee != null){
            contract.setEmployee(employee);
            Contract created = contractRepository.save(contract);
            return contractMapper.toResponseDTO(created);
        }else{
            return null;
        }

    }

    @Override
    public ContractResponseDTO update(Long id, Contract contract){
        Optional<Contract> contrac = contractRepository.findById(id);
        if(contrac.isPresent()){
            Contract created = contractRepository.save(contract);
            return contractMapper.toResponseDTO(created);
        }else{
            return null;
        }
    }

    @Override
    public ContractResponseDTO viewContract(Long id){
        Contract found = contractRepository.findById(id).orElse(null);
        if(found != null){
            return contractMapper.toResponseDTO(found);
        }else{
            return null;
        }
    }

    @Override
    public List<ContractResponseDTO> viewAll(){
        List<ContractResponseDTO> getAll = contractRepository.findAll()
                .stream()
                .map(contractMapper::toResponseDTO)
                .toList();
        return getAll;
    }
}
