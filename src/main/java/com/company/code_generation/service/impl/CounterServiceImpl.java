package com.company.code_generation.service.impl;

import com.company.code_generation.entity.Counter;
import com.company.code_generation.model.CounterDto;
import com.company.code_generation.repository.CounterRepository;
import com.company.code_generation.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class for returning new code
 */
@Service
@RequiredArgsConstructor
public class CounterServiceImpl implements CounterService {

    private final CounterRepository counterRepository;

    /**
     * Method that generate new code.
     * At first, it takes last code from database.
     * If last code is just repeating 'z9' characters
     * then it returns 'a0' repeated lastCode.length() / 2 + 1 times.
     * If not, then it divides last code to char array
     * and replace char with next char where it needed and return new code.
     *
     * @return new code
     */
    @Override
    public CounterDto getCode() {
        String lastCode = counterRepository.findTopByOrderByIdDesc().getCode();

        return saveNewCode(lastCode);
    }

    private CounterDto saveNewCode(String lastCode) {
        String newCode;

        if (!lastCode.equals("z9".repeat(lastCode.length() / 2))) {
            int index = 0;
            char[] chars = lastCode.toCharArray();

            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] != '9' && i == chars.length - 1) {
                    chars[i]++;
                    break;
                } else if (chars[i] == '9' && i == chars.length - 1) {
                    chars[i] = '0';
                    index++;
                } else if ((chars[i] > 47 && chars[i] < 58) && chars[i] != '9' && index == 1) {
                    chars[i]++;
                    break;
                } else if ((chars[i] > 47 && chars[i] < 58) && chars[i] == '9' && index == 1) {
                    chars[i] = '0';
                } else if (chars[i] != 'z') {
                    chars[i] += index;
                    break;
                } else if (chars[i] == 'z') {
                    if (index == 1) {
                        chars[i] = 'a';
                    } else {
                        break;
                    }
                }
            }

            newCode = new String(chars);
        } else {
            newCode = "a0".repeat(lastCode.length() / 2 + 1);
        }

        counterRepository.save(new Counter(newCode));

        return new CounterDto(newCode);
    }
}
