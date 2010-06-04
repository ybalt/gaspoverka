package gaspoverka.data.arch;


public class T {

        private int Number;
        private double VL;
        private double VH;
        private double Error;

        public T(int Number) {
            this.Number = Number;
            this.VH = 0;
            this.VL = 0;
            this.Error = 0;
        }

        public T() {
            this.Number = 0;
            this.VH = 0;
            this.VL = 0;
            this.Error = 0;
        }

        public double getError() {
            return Error;
        }

        public void setError(double Error) {
            this.Error = Error;
        }

        public int getNumber() {
            return Number;
        }

        public void setNumber(int Number) {
            this.Number = Number;
        }

        public double getVH() {
            return VH;
        }

        public void setVH(double VH) {
            this.VH = VH;
        }

        public double getVL() {
            return VL;
        }

        public void setVL(double VL) {
            this.VL = VL;
        }
    };
