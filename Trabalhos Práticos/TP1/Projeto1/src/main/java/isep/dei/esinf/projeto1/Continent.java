package isep.dei.esinf.projeto1;

/**
 *
 * @author 1190402_1191045
 */
public enum Continent {
    /**
     * Africa
     */
    AFRICA {
        @Override
        public String toString() {
            return "Africa";
        }
    },
    /**
     * Asia
     */
    ASIA {
        @Override
        public String toString() {
            return "Asia";
        }
    },
    /**
     * Europe
     */
    EUROPE {
        @Override
        public String toString() {
            return "Europe";
        }
    },
    /**
     * North America
     */
    NORTH_AMERICA {
        @Override
        public String toString() {
            return "North America";
        }
    },
    /**
     * Oceania
     */
    OCEANIA {
        @Override
        public String toString() {
            return "Oceania";
        }
    },
    /**
     * South America
     */
    SOUTH_AMERICA {
        @Override
        public String toString() {
            return "South America";
        }
    };
}
