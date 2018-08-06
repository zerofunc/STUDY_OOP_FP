package help;

import java.util.List;

/**
 * 취합 결과.
 *
 * Created by Doohyun on 2017. 7. 30..
 */
public class StepAverageResultVO {
    private String name;

    private List<CapabilityAverageVO> capabilityAverageVOList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CapabilityAverageVO> getCapabilityAverageVOList() {
        return capabilityAverageVOList;
    }

    public void setCapabilityAverageVOList(List<CapabilityAverageVO> capabilityAverageVOList) {
        this.capabilityAverageVOList = capabilityAverageVOList;
    }

    /**
     * 평균점수 VO
     */
    public static final class CapabilityAverageVO {
        private String kindName;
        private Double averageScore;
        private Integer displayPriority;

        @Override
        public String toString() {
            return String.format("%s : %f", kindName, averageScore);
        }

        public String getKindName() {
            return kindName;
        }

        public void setKindName(String kindName) {
            this.kindName = kindName;
        }

        public Double getAverageScore() {
            return averageScore;
        }

        public void setAverageScore(Double averageScore) {
            this.averageScore = averageScore;
        }

        public Integer getDisplayPriority() {
            return displayPriority;
        }

        public void setDisplayPriority(Integer displayPriority) {
            this.displayPriority = displayPriority;
        }
    }
}
