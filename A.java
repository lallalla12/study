package Chapter09;



	// 바깥 클래스
	 class A {
		A(){System.out.println("A 객체가 생성됨");}
		
		
		// 인스턴스 static 키워드가 없으므로 인스턴스 멤버 클래스
		class B {
			B(){System.out.println("B 객체가 생성됨");}
			int field1;
			// static int field2;
			void method1() {}
			// static void method2(){}
		}
		
		// static 키워드가 있으므로 정적 멤버 클래스
		static class C{
			// 생성자
			C() {System.out.println("C 객체가 생성됨");}
			// 인스턴스 필드
			int field1;
			// 정적 필드
			static int field2;
			// 인스턴스 메소드
			void method1() {}
			// 정적 메소드
			static void method2() {}
		}
		
		void method() {
			// 로컬 클래스
			class D{
				// 생성자
				D(){System.out.println("D 객체가 생성됨");}
				// 인스턴스 필드
				int field1;
				// 정적필드 (x)
				// static int field2;
				//인스턴스 메소드
				void method1() {}
				// 정적 메소드 (x)
				// static void method2(){}
			}
			D d = new D();
			d.field1 = 3;
			d.method1();
		}
	}

