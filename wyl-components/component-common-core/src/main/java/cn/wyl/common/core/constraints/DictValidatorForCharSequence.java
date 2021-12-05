package cn.wyl.common.core.constraints;

import cn.hutool.extra.spring.SpringUtil;
import cn.wyl.common.core.api.RemoteDictService;
import cn.wyl.common.core.dto.MultiResponse;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

public class DictValidatorForCharSequence implements ConstraintValidator<Dict, CharSequence> {

    private String type;

    @Override
    public void initialize(Dict dict) {
        this.type = dict.type();
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        RemoteDictService remoteDictService = SpringUtil.getBean(RemoteDictService.class);
        if (type != null && type.length() > 0) {
            MultiResponse<Map<String, String>> mapMultiResponse = remoteDictService.selectDictDataByType(type);
            return mapMultiResponse.getData().stream().anyMatch(dictData -> {
                return charSequence.equals(dictData.get("dictValue"));
            });
        }
        return true;
    }

}
